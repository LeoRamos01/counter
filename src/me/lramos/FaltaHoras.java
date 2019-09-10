package me.lramos;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * 
 * Coloque a data desejada no {@link #EVENTO} e veja a mágica acontecer.
 * 
 * @author leoramos
 *
 */
public class FaltaHoras {

	private static final LocalDateTime EVENTO = LocalDateTime.of(2020, 1, 1, 0, 0);
	private static final String NOME_EVENTO = "ano novo";

	public static void main(String[] args) throws InterruptedException {
		
		long millis = 0;

		do {
			Thread.sleep(1000);
			
			Stream.iterate(0, i -> i + 1).limit(8).forEach(i -> System.out.println());
			
			LocalDateTime agora = LocalDateTime.now();

			Duration dur = Duration.between(agora, EVENTO);
			millis = dur.toMillis();

			String tempoDecorrido = String.format("%02dh %02dmin %02ds", TimeUnit.MILLISECONDS.toHours(millis),
					TimeUnit.MILLISECONDS.toMinutes(millis)
							- TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
					TimeUnit.MILLISECONDS.toSeconds(millis)
							- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
			
			System.out.println("Restam " + tempoDecorrido + " para " + NOME_EVENTO + ".");
			
		} while (millis >= 0);
		
		Stream.iterate(0, i -> i + 1).limit(8).forEach(i -> System.out.println());
		System.out.println("Evento " + NOME_EVENTO + " concluído.");
	}

}
