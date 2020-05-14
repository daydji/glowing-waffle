package RPIS81.mironyuk.oop.model;

public class AccountManager {
    Individual[] individuals;
    int size;

    public boolean add(Individual individual)
    {

        for (int i=0;i<individuals.length;i++)
            if(individuals[i]==null)
            {
                individuals[i]=individual;
                size=size<=i?i+1:size;
                return true;
            }
        Individual[] individuals1=individuals;
        individuals=new Individual[individuals1.length*2];
        for (int i=0;i<size;i++)
            add(i,individuals1[i]);
        return add(individual);

    }

    public boolean add(int index, Individual individual)
    {
        if(index>=individuals.length){
            Individual[] individuals1=individuals;
            individuals=new Individual[individuals.length*2];
            for (int i=0;i<size;i++)
                add(i,individuals1[i]);
            add(index,individual);}
        else set(index,individual);

        if (index>=size)
            size=index+1;
        return true;
    }

    public Individual get(int index)
    {
        return individuals[index];
    }

    public Individual set(int index, Individual individual)
    {
        Individual individ=individuals[index];
        individuals[index]=individual;
        return individ;
    }

    public Individual remove(int index)
    {
        Individual individ=individuals[index];
        for(;index<size-1;index++)
            individuals[index]=individuals[index+1];
        individuals[index]=null;
        return individ;
    }

    public int size()
    {
        int size=0;
        for(Individual individual:individuals)
            if(individual!=null)size++;
        return size;
    }

    public Individual[] getIndividuals()
    {
        Individual[] individuals=new Individual[size()];
        int i=0;
        for (Individual individual:this.individuals)
            if(individual!=null)
                individuals[i++]=individual;
        return individuals;
    }

    public Individual[] sortedByBalanceIndividuals()
    {
        Individual[] individuals=getIndividuals().clone();
        Individual tmp;
        for (int i=0,k,f;i<individuals.length-1;i++){//Selection sort
            for( k=i+1, f=i;k<individuals.length;k++)
                if(individuals[f].totalBalance()<individuals[k].totalBalance())
                    f=k;
            tmp=individuals[f];
            individuals[f]=individuals[i];
            individuals[i]=tmp;
        }
        return individuals;
    }

    public Account getAccount(String accountNumber)
    {
        for (Individual individual:individuals)
            if(individual.hasAccount(accountNumber))
                return individual.get(accountNumber);
        return null;
    }

    public Account removeAccount(String accountNumber)
    {
        for (Individual individual:individuals)
            if(individual.hasAccount(accountNumber))
                return individual.remove(accountNumber);
        return null;
    }

    public Account setAccount(String accountNumber, Account account)
    {
        for (Individual individual:individuals)
            if(individual.hasAccount(accountNumber)){
                int i=0;
                for (Account account1:individual.getAccounts())
                    if(account1.getNumber().equals(accountNumber))
                    {
                        return individual.set(i,account);
                    }
                    else i++;
            }

        return null;
    }

    public AccountManager(int quantity)
    {
        individuals=new Individual[quantity];
    }

    public AccountManager(Individual[] individuals)
    {
        this.individuals=individuals.clone();
    }
}