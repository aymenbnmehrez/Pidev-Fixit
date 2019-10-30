/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Paiement;
import com.stripe.Stripe;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Token;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author aymen
 */
public class ServicePaiement {
     public boolean payer(String cardNumber,int expYear,int expMonth,String cvc,int price) throws AuthenticationException, InvalidRequestException, CardException, StripeException
    {
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> tokenParams = new HashMap<>();
        Map<String, Object> cardParams = new HashMap<>();
        Paiement p = new Paiement();
        Stripe.apiKey = "sk_test_4AjwOwObKwTFCEPqhgTNyKJ7003iYaG9PT";
        cardParams.put("number", cardNumber);
        cardParams.put("exp_month", expMonth);
        cardParams.put("exp_year", expYear);
        cardParams.put("cvc", cvc);
        int nprice= price*100;
        tokenParams.put("card", cardParams);
        Token token =Token.create(tokenParams);
        if (token.getId()!=null){
        params.put("amount", nprice);
        params.put("currency", "usd");
        params.put("source", token.getId());
        Charge charge = Charge.create(params);
        }
        else 
            return false;
        return true; 
        
    }
}
