Kalendarz z funkcją TODO list
    1. Plik properties z:
        - ścieżka do bazy danych, oddzielny do wydarzeń i odzielny do todo (plik)
        - format daty wejściowej (26012018 3:45 Wiadomość)
        - format daty wyjściowej (wypisanie na ekran)
    2. Funkcje:
        - help - wypisuje liste dostępnych operacji
        - close event - najbliższe wydarzenie
        - all events - wszystkie wydarzenia
        - ADD 26012018 3:45 Nazwa wydarzenia - zapis eventu do pliku
        - TODO Nazwa zadania - zapisz nowe zadanie
    3. Obsługa dwóch typów plików xml i txt
    xml:
        plik1:
            <events>
                <event date="23112017 12:21">Nazwa wydarzenia</event>
                <event date="23112017 12:21">Nazwa wydarzenia</event>
            </events>
        plik2:
            <todos>
                <todo>nazwa todo</todo>
                <todo>nazwa todo</todo>
            </todos>
    txt:
        plik1:
            23112017 12:21 Nazwa wydarzenia
            23112017 12:21 Nazwa wydarzenia
        plik2:
            nazwa todo
            nazwa todo