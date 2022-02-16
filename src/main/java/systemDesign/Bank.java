/**
 * FileName: Bank
 * Author:   Jianhongl
 * Date:     16/2/2022 11:29 pm
 * Description:
 * History:
 */
package systemDesign;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lujianhong
 * @create 16/2/2022
 * @since 1.0.0
 */
public class Bank {
    private final Map<Integer, Long> bank;

    public Bank(long[] balance) {
        bank = new HashMap<>();
        for (int i = 0; i < balance.length; i++) {
            bank.put(i + 1, balance[i]);
        }
    }

    public boolean transfer(int account1, int account2, long money) {
        if (!bank.containsKey(account1) || !bank.containsKey(account2)) {
            return false;
        }

        long firstBilling = bank.get(account1);
        if (firstBilling < money) {
            return false;
        }
        bank.put(account1, firstBilling - money);
        long secondBilling = bank.get(account2);
        bank.put(account2, secondBilling + money);
        return true;
    }

    public boolean deposit(int account, long money) {
        if (!bank.containsKey(account)) {
            return false;
        }

        bank.put(account, bank.get(account) + money);
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (!bank.containsKey(account)) {
            return false;
        }

        long curBilling = bank.get(account);
        if (curBilling < money) {
            return false;
        }
        bank.put(account, curBilling - money);
        return true;
    }
}
