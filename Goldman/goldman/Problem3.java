package goldman;

public class Problem3 {

    // Design Splitwise based on inputs such as inputs = [['a', 'b', 200], ['b', 'c', 300]], 
    //which suggests a pays b 200 so b owes a 200. then answer queries for who owes whom

    // we need to design a class that can take inputs and answer queries

    public void addTransaction(String payer, String receiver, int amount){
        // add the transaction to the ledger
        // update the balances of the payer and receiver
        // if the payer or receiver is not in the ledger, add them
        // if the payer or receiver is already in the ledger, update their balance
        // if the payer owes the receiver, add the amount to the payer's balance and subtract the amount from the receiver's balance
    }

    public void answerQuery(String person){
        // return the balances of the person
        // if the person is not in the ledger, return an empty list and print "No balances owed to this person"
        // if the person owes no one, return an empty list and print "No one owes this person"
        // if the person owes someone, return the list of balances and print the balances               

    }
}