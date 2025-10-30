package no.hvl.dat100.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;
import no.hvl.dat100.oppgave2.*;
import no.hvl.dat100.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static final String TEKST = "TEKST";
	private static final String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {
		Scanner leser = null;

		try {
			leser = new Scanner(new FileReader(mappe + filnavn));

			// første linje = antall innlegg
			int antall = Integer.parseInt(leser.nextLine().trim());
			Blogg samling = new Blogg(antall);

			for (int i = 0; i < antall; i++) {
				String type = leser.nextLine().trim();

				if (type.equals(TEKST)) {
					int id = Integer.parseInt(leser.nextLine().trim());
					String bruker = leser.nextLine().trim();
					String dato = leser.nextLine().trim();
					int likes = Integer.parseInt(leser.nextLine().trim());
					String tekst = leser.nextLine();

					Tekst t = new Tekst(id, bruker, dato, likes, tekst);
					samling.leggTil(t);

				} else if (type.equals(BILDE)) {
					int id = Integer.parseInt(leser.nextLine().trim());
					String bruker = leser.nextLine().trim();
					String dato = leser.nextLine().trim();
					int likes = Integer.parseInt(leser.nextLine().trim());
					String tekst = leser.nextLine().trim();
					String url = leser.nextLine().trim();

					Bilde b = new Bilde(id, bruker, dato, likes, tekst, url);
					samling.leggTil(b);
				}
			}

			leser.close();
			return samling;

		} catch (FileNotFoundException e) {
			System.out.println("Filen ble ikke funnet: " + mappe + filnavn);
			return new Blogg();
		} catch (Exception e) {
			System.out.println("Feil ved lesing av fil: " + e.getMessage());
			return new Blogg();
		} finally {
			if (leser != null) {
				leser.close();
			}
		}
	}
}
