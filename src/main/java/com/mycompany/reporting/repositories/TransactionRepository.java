package com.mycompany.reporting.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mycompany.reporting.domain.Transaction;

@RepositoryRestResource(collectionResourceRel = "transactions", path = "transactions")
public interface TransactionRepository extends PagingAndSortingRepository<Transaction, Long> {
	// @Query(value = "select new
	// com.mycompany.reporting.web.dto.CustomReport(a.entity,a.settlementDate,a.buySell,sum(a.units*a.pricePerUnit*a.agreedFx),count(*))
	// from Transaction a group by a.entity,a.buySell,a.settlementDate order by
	// a.buySell asc,sum(a.units*a.pricePerUnit*a.agreedFx) desc ")
	// public List<CustomReport> createReport();

}
