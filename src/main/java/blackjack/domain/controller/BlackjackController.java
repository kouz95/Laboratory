package blackjack.domain.controller;

import static blackjack.view.InputView.*;
import static blackjack.view.OutputView.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import blackjack.domain.BettingMoney;
import blackjack.domain.PlayerIntentionType;
import blackjack.domain.PlayerMoneys;
import blackjack.domain.card.Deck;
import blackjack.domain.user.Player;
import blackjack.domain.user.User;
import blackjack.domain.user.Users;

public class BlackjackController {
	public static void proceedInitialPhase(Users users, Deck deck) {
		printInitialDistribution(users.getPlayers());
		
		for (User user : users) {
			user.proceedInitialPhase(deck);
			printInitialStatus(user);
		}
	}

	public static PlayerMoneys getBettingMoney(List<Player> players) {
		Map<Player, Integer> result = new HashMap<>();
		players.forEach(player -> result.put(player, BettingMoney.of(inputBettingMoney(player)).intValue()));
		return new PlayerMoneys(result);
	}

	public static void proceedGame(List<Player> players, User dealer, Deck deck) {
		players.forEach(player -> proceedPhaseOf(player, deck));
		proceedPhaseOf(dealer, deck);
	}

	private static void proceedPhaseOf(Player player, Deck deck) {
		while (player.canDrawMore() && PlayerIntentionType.of(inputIntentionOf(player)).isWantDraw()) {
			player.receive(deck.pop());
			printCardsStatusOf(player);
		}
	}

	private static void proceedPhaseOf(User dealer, Deck deck) {
		while (dealer.canDrawMore()) {
			dealer.receive(deck.pop());
			printDealerDrawing();
		}
	}
}
