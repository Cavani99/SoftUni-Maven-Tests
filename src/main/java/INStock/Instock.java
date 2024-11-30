package INStock;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Instock implements ProductStock {

    List<Product> products;

    public Instock() {
        this.products = new ArrayList<>();
    }

    @Override
    public int getCount() {
       return this.products.size();
    }

    @Override
    public boolean contains(Product product) {
        for (int i = 0; i < this.products.size(); i++) {
            if(this.products.get(i).compareTo(product) == 0){
                return true;
            }
        }
       return false;
    }

    @Override
    public void add(Product product) {
        if(!contains(product)){
            this.products.add(product);
        }
    }

    @Override
    public void changeQuantity(String product, int quantity) {
        boolean productExists = false;
        for (int i = 0; i < this.products.size(); i++) {
            if(this.products.get(i).getLabel().contains(product)){
                this.products.get(i).setQuantity(quantity);
                productExists = true;
            }
        }
        if(!productExists){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Product find(int index) {
        if(this.products.size() - 1 < index){
            throw new IndexOutOfBoundsException();
        }

        return this.products.get(index);
    }

    @Override
    public Product findByLabel(String label) {
        for (int i = 0; i < this.products.size(); i++) {
            if(this.products.get(i).getLabel().equals(label)){
               return this.products.get(i);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        ArrayList<Product> result = new ArrayList<>();
        if (!(count <= 0 || count > this.getCount())) {
            this.products
                    .stream()
                    .sorted(Product::compareTo)
                    .limit(count)
                    .forEach(result::add);
        }
        return result;
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        return this.products.stream()
                .filter(e -> e.getPrice() > lo && e.getPrice() <= hi)
                .sorted((f, s) -> Double.compare(s.getPrice(), f.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        return this.products.stream()
                .filter(e -> e.getPrice() == price)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        ArrayList<Product> result = new ArrayList<>();
        if (!(count <= 0 || count > this.getCount())) {
            this.products
                    .stream()
                    .sorted((f, s) -> Double.compare(s.getPrice(), f.getPrice()))
                    .limit(count)
                    .forEach(result::add);
        }
        if(result.size() < count){
            throw new IllegalArgumentException();
        }
        return result;
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        return this.products.stream()
                .filter(e -> e.getQuantity() == quantity)
                .collect(Collectors.toList());
    }

    @Override
    public Iterator<Product> iterator() {
        return this.products.stream().iterator();
    }
}
