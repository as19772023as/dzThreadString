### Интервал значений

программа,  генерирует 25 строк размером 30 000 символов, которые состоят из символов 'a' и 'b'.
Для каждой строки - найти размер наибольшего промежутка, состоящего из одних символов 'a'. 
для строки "aaababbaaaaabaa" ответом будет число 5 — 5 символов 'a' подряд.


неэффективный алгоритм, который перебирает всевозможные индексы потенциального начала этого промежутка и всевозможные индексы конца, после чего проверяет, есть ли между ними символ 'b'.
Если символ 'b' не был найден, то программа запоминает размер этого промежутка при условии, что он оказался максимальным.