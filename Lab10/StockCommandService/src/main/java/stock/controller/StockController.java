package stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import stock.domain.Stock;
import stock.service.StockService;

@RestController
@RequestMapping("/api/v1/stocks")
public class StockController {

    @Autowired
    StockService stockService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Stock add(@RequestBody Stock stock){
        return stockService.add(stock);
    }

    @PutMapping("/{productNo}")
    @ResponseStatus(HttpStatus.OK)
    public Stock update(@PathVariable("productNo") Long productNo, @RequestBody Stock stock) {
        return stockService.update(productNo, stock);
    }

    @DeleteMapping("/{productNo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("productNo") Long productNo) {
        stockService.delete(productNo);
    }

}
