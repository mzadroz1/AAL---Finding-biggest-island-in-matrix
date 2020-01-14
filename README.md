# AAL---Finding-biggest-island-in-matrix

AAL
Michał Zadrożny
Projekt 14 - Archipelag, prowadzący: Kamil Deja

specyfikacja problemu:
Algorytm na wejściu otrzymuje macierz wypełnioną zerami oraz jedynkami. 
Na wyjściu powinien podać rozmiar największej „wysypy jedynek” – fragmentu macierzy, 
w którym jedynki ze sobą sąsiadują (w poziomie, w pionie lub po skosie).

aktywacja programu:
- wybranie trybu: 
	-m1 dane ze standardowego wejścia, wynik na standardowe wyjście
	-m2 macierz losowana na podstawie podanych parametrów
	-m3 przeprowadzenie pełnego procesu testowania z pomiarem czasów wykonania
- ustalenie parametrów (dotyczy trybów -m2 i -m3):
	-n ilość wierszy macierzy
	-m ilość kolumn macierzy
	-p prawdopodobieństwo wylosowania jedynki w macierzy 
	-alg wybór stosowanego algorytmu (do wyboru dfs lub (domyślnie)bfs)
- parametry testowania (dotyczy tylko trybu -m3)
	-k ilość testowanych wielkości problemów
	-step wartość, o którą zwiększane jest n oraz m przy kolejnej wielkości problemu (kolejnej iteracji)
	-r ilość rozpatrywanych instancji problemu danej wielkości
przykłady:
java Main -m1 -alg dfs
java Main -m2 -n 5 -m 5 p -0.25
java Main -m3 -n 10 -m 10 -p 0.3 -step 10 -k 30 -r 10

współpraca z plikami:
wczytanie danych wejściowych z pliku w trybie pierwszym: dodanie na koniec komendy <in.txt
przekierowanie wyjścia do pliku: dodanie na koniec komendy >out.txt

dane wejściowe:
konwencja wprowadzania danych:
n
m
<macierz>
przykładowo:
3
3
100
010
000

prezentacja wyników: wyświetlenie rozpatrywanej macierzy oraz podanie wielkości największej wyspy
W trybie -m3 wyświetlane są kolejne rozpatrywane macierze wraz z czasami rozwiązania.
Na koniec wyświetlane są uśrednione czasy wykonania dla kolejnych wielkości problemów
wraz ze współczynnikiem zgodności oceny teoretycznej z pomiarem czasu

pliki źródłowe:
Main.java - obsługa argumentów wywołania programu, tworzenie macierzy i wywoływanie odpowiednich metod
Matrix.java - klasa reprezentująca macierz. Wśród metod klasy znajduje się losowe generowanie macierzy
(jeden z konstruktorów), wyświetlanie macierzy oraz same algorytmy znajdowania największej wyspy (BFS i DFS).
 	
