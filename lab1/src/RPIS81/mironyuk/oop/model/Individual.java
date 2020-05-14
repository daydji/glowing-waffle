package RPIS81.mironyuk.oop.model;

public class Individual {
    Account[] accounts;
    int size=0;
    public boolean add(Account account)
    {

        for (int i=0;i<accounts.length;i++)
            if(accounts[i]==null)
            {
                accounts[i]=account;
                size=size<=i?i+1:size;
                return true;
            }
        Account[] accounts1=accounts;
        accounts=new Account[accounts1.length*2];
        for (int i=0;i<size;i++)
            add(i,accounts1[i]);
        return add(account);

    }

    public boolean add(int index,Account account){
        if(index>=accounts.length){
            Account[] accounts1=accounts;
            accounts=new Account[accounts1.length*2];
            for (int i=0;i<size;i++)
                add(i,accounts1[i]);
            add(index,account);}
        else set(index,account);

        if (index>=size)
            size=index+1;
        return true;
    }

    public Account get(int index)
    {
        return accounts[index];
    }

    public Account get(String accountNumber)
    {
        for (Account account: accounts) {
            if(accountNumber.equals(account.getNumber()))
                return account;

        }
        return null;
    }

    public boolean hasAccount(String accountNumber)
    {
        for (Account account: accounts) {
            if(accountNumber.equals(account.getNumber()))
                return true;

        }
        return false;
    }

    public Account set(int index,Account account)
    {
        Account deletedAccount=get(index);
        accounts[index]=account;
        return deletedAccount;
    }

    public  Account remove(int index)
    {
        Account deletedAccount=get(index);
        for (int i=index;i<size-1;i++)
            accounts[i]=accounts[i+1];
        accounts[size-1]=null;
        size--;
        return deletedAccount;
    }

    public  Account remove(String accountNumber)
    {
        for (int i=0;i<size;i++) {
            if(accountNumber.equals(accounts[i].getNumber()))
            {
                return remove(i);
            }
        }
        return null;
    }

    public int size()
    {
        int size=0;
        for(Account account:accounts)
            if(account!=null)size++;
        return size;
    }

    public Account[] getAccounts()
    {
        Account[] accounts=new Account[size()];
        int i=0;
        for (Account account:this.accounts)
            if(account!=null)
                accounts[i++]=account;
        return accounts;
    }

    public Account[] sortedAccountsByBalance()
    {
        Account[] accounts=getAccounts().clone();
        Account tmp;
        for (int i=0,k,f;i<accounts.length-1;i++){//Selection sort
            for( k=i+1, f=i;k<accounts.length;k++)
                if(accounts[f].getBalance()<accounts[k].getBalance())
                    f=k;
            tmp=accounts[f];
            accounts[f]=accounts[i];
            accounts[i]=tmp;
        }
        return accounts;
    }

    public double totalBalance()
    {
        double sum=0.0;
        for (Account account: getAccounts())
            sum+=account.getBalance();
        return sum;
    }

    public Individual()
    {
        accounts=new Account[16];
    }

    public Individual(int length)
    {
        accounts=new Account[length];
    }

    public Individual(Account[] accounts)
    {
        this.accounts=new Account[accounts.length];
        for (Account account: accounts) {
            add(new Account(account.getNumber(),account.getBalance()));
        }
    }
}
