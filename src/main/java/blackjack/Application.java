package blackjack;

import static blackjack.view.InputView.*;
import static blackjack.view.OutputView.*;

import blackjack.domain.PlayerMoneys;
import blackjack.domain.card.CardRepository;
import blackjack.domain.card.Deck;
import blackjack.domain.controller.BlackjackController;
import blackjack.domain.user.Dealer;
import blackjack.domain.user.User;
import blackjack.domain.user.Users;

public class Application {
	public static void main(String[] args) {
		User dealer = new Dealer();
		Deck deck = Deck.of(CardRepository.toList());
		Users users = Users.of(inputPlayerNames(), dealer);
		PlayerMoneys playerMoneys = BlackjackController.getBettingMoney(users.getPlayers());

		BlackjackController.proceedInitialPhase(users, deck);

		if (dealer.isNotBlackJack()) {
			BlackjackController.proceedGame(users.getPlayers(), dealer, deck);
		}

		printResultStatus(users);
		printResultProfit(playerMoneys, dealer);
	}
}
