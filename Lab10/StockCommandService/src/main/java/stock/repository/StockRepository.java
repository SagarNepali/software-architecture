package stock.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import stock.domain.Stock;

@Repository
public interface StockRepository extends MongoRepository<Stock, Long> {

    Stock findStockByProductNo(Long productNo);
}

