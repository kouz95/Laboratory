package blackjack.domain.user;

import java.util.ArrayList;
import java.util.Objects;

import blackjack.domain.card.Card;
import blackjack.domain.card.Cards;
import blackjack.domain.card.Deck;
import blackjack.domain.user.strategy.draw.DrawStrategy;

public abstract class User {
	private static final int BLACKJACK_SCORE = 21;
	private static final int INITIAL_HANDS_SIZE = 2;

	protected Cards hands;
	protected DrawStrategy drawStrategy;

	protected User() {
		this.hands = new Cards(new ArrayList<>());
	}

	public void proceedInitialPhase(Deck deck) {
		for (int i = 0; i < INITIAL_HANDS_SIZE; i++) {
			hands.add(deck.pop());
		}
	}

	public boolean canDrawMore() {
		return drawStrategy.canDraw(hands.getPoint());
	}

	public void receive(Card card) {
		hands.add(card);
	}

	public boolean isNotBlackJack() {
		return hands.isNotInitialSize() || hands.getPoint() != BLACKJACK_SCORE;
	}

	public int getScoreMinusBy(User compared) {
		return hands.getPoint() - compared.hands.getPoint();
	}

	public Cards openAllCards() {
		return hands;
	}

	public abstract Cards openInitialCards();

	@Override
	public abstract String toString();

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		User user = (User)o;
		return Objects.equals(hands, user.hands);
	}

	@Override
	public int hashCode() {
		return Objects.hash(hands);
	}
}
