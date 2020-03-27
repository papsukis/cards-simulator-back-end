package com.papsukis.CardSimulator.Decklist.repository;

import com.papsukis.CardSimulator.Decklist.DTO.CardDTO;
import com.papsukis.CardSimulator.Decklist.models.Card;
import com.papsukis.CardSimulator.Decklist.models.SearchQueryResults;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CustomCardRepositoryImpl implements CustomCardRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public SearchQueryResults search(CardDTO card, int firstResult, int maxResults) {

        Session session = em.unwrap(Session.class);

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<Card> cardCriteriaQuery = criteriaBuilder.createQuery(Card.class);

        Root<Card> from = cardCriteriaQuery.from(Card.class);

        List<Predicate> predicates = new ArrayList<Predicate>();

        //Adding predicates in case of parameter not being null

        if (!card.getName().equals("undefined")) {
            predicates.add(
                    criteriaBuilder.like(from.get("name"), "%"+card.getName()+"%")
            );
        }
        if (!card.getArchetype().equals("undefined")) {
            predicates.add(
                    criteriaBuilder.like(from.get("archetype"), "%"+card.getArchetype()+"%")
            );
        }
        if (!card.getRace().equals("undefined")) {
            predicates.add(
                    criteriaBuilder.like(from.get("race"), "%"+card.getRace()+"%")
            );
        };
        if (!card.getAtribute().equals("undefined")) {
            predicates.add(
                    criteriaBuilder.like(from.get("atribute"), "%"+card.getAtribute()+"%")
            );
        }
        if (!card.getType().equals("undefined")) {

            predicates.add(
                    criteriaBuilder.like(from.get("type"), "%"+card.getType()+"%")
            );
        }
        if (!card.getDesc().equals("undefined")) {

            predicates.add(
                    criteriaBuilder.like(from.get("desc"), "%"+card.getDesc()+"%")
            );
        }
        if(card.getMaxAtk() != 0 || card.getMinAtk() != 0)
        {
            predicates.add(
                    criteriaBuilder.between(from.get("atk"),card.getMinAtk(),card.getMaxAtk())
            );
        }
        if(card.getMaxDef() != 0 || card.getMinDef() != 0)
        {
            predicates.add(
                    criteriaBuilder.between(from.get("atk"),card.getMinDef(),card.getMaxDef())
            );
        }


        cardCriteriaQuery
                .where(predicates.toArray(new Predicate[]{}));


        TypedQuery<Card> query = session.createQuery(cardCriteriaQuery);

        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        Root<Card> entity_ = countQuery.from(cardCriteriaQuery.getResultType());
        countQuery.select(criteriaBuilder.count(entity_));
        Predicate restriction = cardCriteriaQuery.getRestriction();
        if (restriction != null) {
            countQuery.where(predicates.toArray(new Predicate[]{})); // Copy restrictions
        }
        int totalCount=(int) (long) em.createQuery(countQuery).getSingleResult();


        query.setFirstResult(firstResult);
        query.setMaxResults(maxResults);
        SearchQueryResults result=new SearchQueryResults();
        result.setResultSize(totalCount);
        result.setQueryResults(query.getResultList());

        return result;

    }


}
