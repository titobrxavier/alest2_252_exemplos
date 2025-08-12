# "Receita de bolo" para fazer gráficos a partir
# de um arquivo de dados com o Gnuplot

# Ajuste conforme a necessidade. Para plotar mais de um
# arquivo de dados, separe por vírgulas
# ex: plot "a.txt" with lines, "b.txt" with lines, ...

# Execute com: gnuplot plot.gnu
# Irá gerar o arquivo de saída "saida.pdf"

# Gera dois gráficos: compara2.pdf (merge + quick) e compara3.pdf (bubble + merge + quick)
# (usei a saída em C, se quiserem ver as outras é só trocar abaixo)

set term pdf
set output "compara3.pdf"
plot "bubble_c.txt" with lines title "Bubble", "merge_c.txt" with lines title "Merge", "quick_c.txt" with lines title "Quick"
set output "compara2.pdf"
plot "merge_c.txt" with lines title "Merge", "quick_c.txt" with lines title "Quick"
