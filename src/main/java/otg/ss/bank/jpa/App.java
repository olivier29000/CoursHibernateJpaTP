package otg.ss.bank.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import otg.ss.bank.jpa.domain.Account;
import otg.ss.bank.jpa.domain.Address;
import otg.ss.bank.jpa.domain.Agency;
import otg.ss.bank.jpa.domain.ChargedAccount;
import otg.ss.bank.jpa.domain.SavingAccount;
import otg.ss.bank.jpa.domain.SimpleAccount;
import otg.ss.bank.jpa.domain.Transaction;
import otg.ss.bank.jpa.domain.Transaction.Type;

public class App {

	public static void main(String... args) {

		// findAgency();
		Agency agency = new Agency("SSSSSSSSSS", new Address("15", "street", "44000", "city"));
		agency.addAccount(new SavingAccount(999, 9));
		agency.addAccount(new ChargedAccount(888));
		Account account1 = new SimpleAccount(777, 7);
		agency.addAccount(account1);

		Transaction transaction = new Transaction();
		transaction.setAccount(account1);
		transaction.setAgency(agency);
		transaction.setAmount(500);
		transaction.setType(Type.IPM);

		account1.addTransaction(transaction);

		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("tp-hibernate-jpa");
			em = emf.createEntityManager();

			em.getTransaction().begin();

			em.persist(agency);

			em.getTransaction().commit();

		} finally {
			if (em != null)
				em.close();
			if (emf != null)
				emf.close();
		}
	}

	public static void insererAgencyEtAccount(Agency agency, Account account) {

	}

	public static void findAgency() {

		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("tp-hibernate-jpa");
			em = emf.createEntityManager();

			Agency agency = em.find(Agency.class, 1l);
			if (agency != null) {
				// traitement
				System.out.println(agency.toString());
				agency.setCode("DDDDDDD");

				em.getTransaction().begin();
				em.remove(agency);
				em.getTransaction().commit();
				System.out.println(agency.toString());

			}

		} finally {
			if (em != null)
				em.close();
			if (emf != null)
				emf.close();
		}

	}

	public static void insererAgency(Agency agency) {

		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("tp-hibernate-jpa");
			em = emf.createEntityManager();

			em.getTransaction().begin();

			em.persist(agency);

			em.getTransaction().commit();

		} finally {
			if (em != null)
				em.close();
			if (emf != null)
				emf.close();
		}

	}
}
