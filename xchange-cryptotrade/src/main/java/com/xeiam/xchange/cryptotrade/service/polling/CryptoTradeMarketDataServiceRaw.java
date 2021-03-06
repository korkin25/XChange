package com.xeiam.xchange.cryptotrade.service.polling;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.cryptotrade.CryptoTrade;
import com.xeiam.xchange.cryptotrade.dto.CryptoTradeException;
import com.xeiam.xchange.cryptotrade.dto.CryptoTradePair;
import com.xeiam.xchange.cryptotrade.dto.CryptoTradePairs;
import com.xeiam.xchange.cryptotrade.dto.marketdata.CryptoTradeDepth;
import com.xeiam.xchange.cryptotrade.dto.marketdata.CryptoTradePublicTrade;
import com.xeiam.xchange.cryptotrade.dto.marketdata.CryptoTradePublicTrades;
import com.xeiam.xchange.cryptotrade.dto.marketdata.CryptoTradeTicker;
import com.xeiam.xchange.cryptotrade.dto.marketdata.CryptoTradeTickers;
import com.xeiam.xchange.currency.CurrencyPair;

public class CryptoTradeMarketDataServiceRaw extends CryptoTradeBasePollingService<CryptoTrade> {

  /**
   * Constructor
   *
   * @param exchange
   */
  public CryptoTradeMarketDataServiceRaw(Exchange exchange) {

    super(CryptoTrade.class, exchange);
  }

  public CryptoTradeTicker getCryptoTradeTicker(CurrencyPair currencyPair) throws CryptoTradeException, IOException {

    CryptoTradeTicker cryptoTradeTicker = cryptoTradeProxy.getTicker(currencyPair.baseSymbol.toLowerCase(), currencyPair.counterSymbol.toLowerCase());

    return handleResponse(cryptoTradeTicker);
  }

  public Map<CurrencyPair, CryptoTradeTicker> getCryptoTradeTickers() throws CryptoTradeException, IOException {

    CryptoTradeTickers cryptoTradeTickers = cryptoTradeProxy.getTickers();

    return handleResponse(cryptoTradeTickers).getTickers();
  }

  public CryptoTradeDepth getCryptoTradeOrderBook(CurrencyPair currencyPair) throws CryptoTradeException, IOException {

    CryptoTradeDepth cryptoTradeDepth = cryptoTradeProxy.getFullDepth(currencyPair.baseSymbol.toLowerCase(), currencyPair.counterSymbol.toLowerCase());

    return handleResponse(cryptoTradeDepth);
  }

  public List<CryptoTradePublicTrade> getCryptoTradeTradeHistory(CurrencyPair currencyPair) throws CryptoTradeException, IOException {

    CryptoTradePublicTrades cryptoTradeDepth = cryptoTradeProxy.getTradeHistory(currencyPair.baseSymbol.toLowerCase(), currencyPair.counterSymbol.toLowerCase());

    return handleResponse(cryptoTradeDepth).getPublicTrades();
  }

  public List<CryptoTradePublicTrade> getCryptoTradeTradeHistory(CurrencyPair currencyPair, long sinceTimestamp) throws CryptoTradeException, IOException {

    CryptoTradePublicTrades cryptoTradeDepth = cryptoTradeProxy.getTradeHistory(currencyPair.baseSymbol.toLowerCase(), currencyPair.counterSymbol.toLowerCase(), sinceTimestamp);

    return handleResponse(cryptoTradeDepth).getPublicTrades();
  }

  public CryptoTradePair getCryptoTradePairInfo(CurrencyPair currencyPair) throws CryptoTradeException, IOException {

    CryptoTradePair cryptoTradePair = cryptoTradeProxy.getPair(currencyPair.baseSymbol.toLowerCase(), currencyPair.counterSymbol.toLowerCase());

    return handleResponse(cryptoTradePair);
  }

  public Map<CurrencyPair, CryptoTradePair> getCryptoTradePairs() throws CryptoTradeException, IOException {

    CryptoTradePairs cryptoPairs = cryptoTradeProxy.getPairs();

    return handleResponse(cryptoPairs).getPairs();
  }
}
