package blackjack.domain.user;

import java.util.Collections;

import blackjack.domain.card.Cards;
import blackjack.domain.user.strategy.draw.DealerDrawStrategy;

public class Dealer extends User {
	private static final int FIRST_CARD_INDEX = 0;

	public Dealer() {
		drawStrategy = new DealerDrawStrategy();
	}

	@Override
	public Cards openInitialCards() {
		return new Cards(Collections.singletonList(hands.toList().get(FIRST_CARD_INDEX)));
	}

	@Override
	public String toString() {
		return "딜러";
	}
}
