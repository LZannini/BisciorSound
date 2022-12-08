TRACCIA 1: SISTEMA DI GESTIONE LIBRERIA MUSICALE DI UN GRUPPO DI UTENTI
Si sviluppi un sistema informativo, composto da una base di dati relazionale e da un applicativo Java dotato
di GUI (Swing o JavaFX), per la gestione delle librerie musicali di un gruppo di utenti. Il sistema permette di
gestire le tracce, gli ascolti delle singole tracce e le liste dei brani preferiti dei singoli utenti. Di ogni traccia si
deve gestire l’album di appartenenza (ogni traccia ha un solo album di appartenenza – remastering diversi
della stessa traccia possono far parte di album diversi), l’artista e la versione (l’anno). Ogni utente è
identificato da un nome utente, univoco in tutto il sistema. Una traccia è identificata dall’album di
appartenenza, dall’autore e dall’anno. Modellare il concetto di cover, secondo il quale, una traccia “nasce”
in un determinato anno e un artista ne effettua una personale rivisitazione. Il concetto di cover è diverso dal
concetto di remastering: la cover è una traccia eseguita da un altro artista, il remastering è la stessa traccia
le cui equalizzazioni vengono modificate utilizzando tecnologie diverse.
Il sistema permette ad un admin di recuperare, data una certa traccia, un sottoinsieme degli utenti che hanno
effettuato più ascolti di quella traccia, andando a differenziare la versione per cui è stata ascoltata la traccia.
Deve essere inoltre possibile andare a identificare la fascia oraria in cui un determinato utente ha effettuato
più ascolti (definire un set di fasce orarie, per semplificare il compito).