package com.papsukis.CardSimulator.repository;

import com.papsukis.CardSimulator.DTO.CardDTO;
import com.papsukis.CardSimulator.models.Card;
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
    public List<Card> search(CardDTO card) {

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

      //  cardCriteriaQuery

        TypedQuery<Card> query = session.createQuery(cardCriteriaQuery);
        List<Card> results = query.getResultList();

        return results;

    }


}
