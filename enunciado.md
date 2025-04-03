O labirinto do horror II

Na segunda etapa de sua escavação arqueológica em Creta, você decifra mais inscrições e descobre por que a civilização cretense foi desestabilizada e destruída, mesmo com Ariadne tendo salvo Teseu do Minotauro. Os labirintos das lendas eram descritos por _m_ × _n_ células e cada célula _cij_ podia se conectar com as células imediatamente acima, abaixo, à esquerda e à direita. Os cretenses já conheciam a numeração hexadecimal e codificavam as paredes de cada célula com um número

de 4 bits, indicando se existiam ou não paredes para as células vizinhas. Os bits correspondiam às paredes nesta ordem: superior, direita, inferior e esquerda. Um exemplo é o labirinto da figura abaixo:

![](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAL8AAAC/CAYAAACv6g0GAAAABlBMVEUAAAD///+l2Z/dAAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAA7EAAAOxAGVKw4bAAAEW0lEQVR4nO3dP24cdRzG4TcIAQVFIlFQgS0O4ECTMuEEOCdgO4RouAFQIEHl3CCpqJBwThBzAkyPhOECMQ2iIhS7Astak5Hi+ZN9n0caaT2y9PuN96PV7BRfJwAAwC67cenn20kON6/3kry7eX2W5LdptjS7k80xls+T3Ny8vpPkjc3rH0dck3XDj/7vF1ZJnpUfRwP+kC/ipwVcY+Pxw+U34pXt7w/sPvFTS/zUEj+1Xh34e4+THI+5kRnczfoL/lJ8luTPuTexAw6yfqL2XEPjP81zHhO9pFZzb+CC75Kcz72JHXAvA+N320Mt8VNL/NQSP7XETy3xU0v81BI/tcRPLfFTS/zUEj+1xE8t8VNL/NQSP7XETy3xU0v81BI/tcRPLfFTa+jokik9zX9TjJs8nWid4yT3J1pr0XzyU0v81BI/Y3qS7bPy92bc07/ET60lfuE9zzQzK99M8tYE6wz1e5K/J1jnlwnWeCksMf79idZZJXk40VpDHMSg2km57aGW+KklfmqJn1rip5b4qSV+aomfWuKnlvipJX5qiZ9a4qeW+KklfmqJn1rip5b4qSV+aomfWuKnlvipNXR0yd0kX464j4umWqfJXpLDGdZd9MDhofHf2xxTeBDza67b7SRHc29iadz2UEv81BI/tcRPraFfeB9n/e9sprDrX3a/znpC9GVzXPdJ1u/t1BbxHg+N/zTJoxH30eT7uTdwwVnWT9cque2hlvipJX5qiZ9a4qeW+KklfmqJn1rip5b4qSV+aomfWuKnlvipJX5qiZ9a4qeW+KklfmqJn1rip5b4qTV0dMmUfs00031fu+L8p0lWE6zf4EnWQ3IXaYnx38y8o61f3xxcj8WOKXfbQy3xU0v81BI/tZb4hffW3BtgdPtZD8mdlU9+aomfWuKnlvipJX5qiZ9a4qeW+KklfmqJn1rip5b4qSV+aomfWuKnlvipJX5qiZ9a4qeW+KklfmqJn1pLGV2ymnsDjOLtGdbcS3Jvy/mzJCcXTywl/i+y3jS8qL0kD7ecP86l+N32UEv81BI/tcRPraV84b3KgyR/zL2Ja/ZJtj8F+TbJXxPvZWwfZ8EPMpYe/1dJzufexDX7KNvj/ya7d613s+D43fZQS/zUEj+1xE8t8VNL/NQSP7XETy3xU0v81BI/tcRPLfFTS/zUEj+1xE8t8VNL/NQSP7XETy3xU0v81BI/tcRPLfFTaynx7ye5teUYc4LZKsmzLcfRiGsmyftJbmw5xrzWw2y/1m1z7K/Th5n+fR1sSeMKF/EH4dot9n1dyic/TE781BI/tcRPLfFTS/zUEj+1xE8t8VNL/NQSP7XETy3xU0v81BI/tcRPLfFTS/zUEj+1xE8t8VNL/NQSP7XET62hQ6sOsp76tUs+uOL8e9m9a71zxfl3snvXujf0F29c+nmV8UfYwRyOk9y/eMJtD7XETy3xU0v81Lr8tOc0yYM5NgIj+3nuDQAAzOQf03D2TKtJUAQAAAAASUVORK5CYII=)Neste exemplo a célula inferior esquerda (chamada de _c_61) é codificada por 0011, indicando que existem paredes abaixo e à esquerda. Da mesma forma, todas as outras células recebem um dos dezesseis códigos possíveis.

O problema dos cretenses é que eles tinham _m_, _n_ e a descrição das _m_ × _n_ células do labirinto, mas muitas vezes existiam regiões do labirinto que eram inatingíveis a partir de outras regiões. Ou seja, poderia ser que Teseu estivesse em uma região fechada, Ariadne estivesse em outra e o Minotauro em uma terceira, e eles nunca se encontrariam. Dois exemplos seguem, mostrando as entradas de dados, onde temos labirintos divididos em regiões distintas e sem conexão:

4 4

9 A a 6

5 9 A c

5 5 F 3

7 3 A e


6 6
9 E b A a E

3 a E b 8 8

D d 9 a 4 7

5 5 3 e 5 D

1 0 C 9 2 6

7 7 5 3 a e

Há um detalhe adicional: por algum motivo desconhecido, esses labirintos eram povoados por Anões, Bruxas, Cavaleiros, Duendes, Elfos e Feijões. As células com esses seres são indicadas com o valor hexa EM MAIÚSCULA.

Portanto, sua missão é receber vários arquivos descrevendo labirintos diferentes e informar:

1. Quantas regiões diferentes de células isoladas existem no labirinto; e
2. Considerando todas as regiões, qual é o tipo de ser que mais aparece numa dada região?

Para o labirinto acima à esquerda, existem três regiões isoladas e para o da direita existem quatro regiões. No labirinto da esquerda, o ser que mais aparece numa região é o Anão. Já no labirinto da direita, o que mais aparece numa região é o Elfo.

Você deve apresentar um relatório incluindo:

- - A descrição do problema e como ele foi resolvido;
    - Detalhes de algoritmos e pseudo-código adequado;
    - Resultados dos casos de teste fornecidos;
    - Análise e dados de desempenho do algoritmo;
    - Conclusões.