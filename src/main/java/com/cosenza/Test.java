package com.cosenza;

import com.cosenza.utils.Constants;
import com.oanda.v20.Context;
import com.oanda.v20.ContextBuilder;
import com.oanda.v20.ExecuteException;
import com.oanda.v20.RequestException;
import com.oanda.v20.account.AccountContext;
import com.oanda.v20.account.AccountID;
import com.oanda.v20.account.AccountSummary;
import com.oanda.v20.instrument.Candlestick;
import com.oanda.v20.instrument.CandlestickGranularity;
import com.oanda.v20.pricing.*;
import com.oanda.v20.pricing_common.*;
import com.oanda.v20.primitives.DateTime;
import com.oanda.v20.primitives.InstrumentName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Test
{
    public static void main(String[] args)
    {
        Context context = new ContextBuilder(Constants.URL).setToken(Constants.TOKEN).setApplication("CandlestickPrice").build();

        //context.account.

        try
        {
            AccountSummary summary = context.account.summary(
                    new AccountID(Constants.ACCOUNT_ID)).getAccount();
            System.out.println(summary);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        //Gets historical data for any number of instruments
        try
        {
            PricingCandlesRequest request = new PricingCandlesRequest(new InstrumentName("USD_JPY"));
            request.setPathParam("accountID", new AccountID(Constants.ACCOUNT_ID));
            request.setPrice("BA");
            //request.setCount(10L);
            request.setFrom(new DateTime("1596853963"));
            request.setTo(new DateTime("1598409163"));
            request.setGranularity(CandlestickGranularity.H4);

            //PricingCandlesResponse response = context.pricing.candles(Constants.INSTRUMENT);


            PricingCandlesResponse response = context.pricing.candles(request);
            List<Candlestick> prices = response.getCandles();

            for (Candlestick candlestick:prices)
            {
                System.out.println("Bid: " + candlestick.getBid().getO());
                System.out.println("Ask: " + candlestick.getAsk().getO());
            }

            Thread.sleep(1000);


        } catch (InterruptedException | RequestException | ExecuteException e)
        {
            e.printStackTrace();
        }


        //Gets a stream of pricing data for any number of instruments
        /*
        List<String> instruments = new ArrayList<>(Arrays.asList("EUR_USD", "USD_JPY", "GBP_USD", "USD_CHF"));

        try{
           PricingGetRequest request = new PricingGetRequest(Constants.ACCOUNT_ID, instruments);
           DateTime since = null;

           while (true)
           {
               if(since != null)
               {
                   System.out.println("Polling since: " + since);
                   request.setSince(since);
               }
               PricingGetResponse response = context.pricing.get(request);
               for(ClientPrice price : response.getPrices())
               {
                   System.out.println(price);
               }

               since = response.getTime();

               Thread.sleep(1000);
           }
        } catch (RequestException | InterruptedException | ExecuteException e) {
            e.printStackTrace();
        }
*/

    }
}