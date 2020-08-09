package com.cosenza;

import com.oanda.v20.Context;
import com.oanda.v20.account.AccountID;
import com.oanda.v20.account.AccountSummary;

public class Test
{
    public static void main(String[] args)
    {

        Context ctx = new Context(
                "https://api-fxpractice.oanda.com",
                "f508663a3098c2b27f3087a0d9e921e2-266fe6172c4446a0dafb662a713dead9");

        try {
            AccountSummary summary = ctx.account.summary(
                    new AccountID("101-001-10809598-005")).getAccount();
            System.out.println(summary);
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
