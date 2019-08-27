package otg.ss.bank.jpa.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Agency implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String code;
	@Embedded
	private Address address;

	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "agency")
	private Set<Account> accounts;
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "agency")
	private Set<Transaction> transactions;

	/**
	 * Constructeur
	 * 
	 */
	public Agency() {
		address = new Address();
		accounts = new HashSet<>();
		transactions = new HashSet<>();
	}

	public Agency(String code, Address address) {
		this();
		this.code = code;
		this.address = address;
	}

	public Agency(Long id, String code, Address address) {
		this();
		this.id = id;
		this.code = code;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	public void addAccount(Account account) {
		account.setAgency(this);
	}

	public void removeAccount(Account account) {
		account.setAgency(null);
	}

	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Agency{");
		sb.append("id=").append(id);
		sb.append(", code='").append(code).append('\'');
		sb.append(", address=").append(address);
		sb.append('}');
		return sb.toString();
	}
}