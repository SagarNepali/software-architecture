package stock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stock.domain.Stock;
import stock.repository.StockRepository;

@Service
public class StockService {

    @Autowired
    StockRepository stockRepository;

    public Stock add(Stock product) {
        return stockRepository.save(product);
    }

    public Stock update(Long productNo, Stock stock) {
        Stock data = findById(productNo);
        if(data !=null) {
            stockRepository.save(stock);
        }else{
            throw new IllegalArgumentException("No product found of id: "+productNo);
        }
        return stock;
    }

    public void delete(Long productNo) {
        Stock product  = findById(productNo);
        if(product != null) {
            stockRepository.delete(product);
        }else{
            throw new IllegalArgumentException("No product found of id: "+productNo);
        }
    }

    public Stock findById(Long productNo) {
        return stockRepository.findStockByProductNo(productNo);
    }
}
