# Java8 - RinaldoDev
- __Lambda__ (Veio para viabilizar a programação funcinal no Java, busca evitar a implementação da classe anônima, permite implementar uma interface funcional "Respeita o SAM - Single Method Abstraction", o lado esquerdo sao os parametros e o direito a implementação)  
  
  
- __Streams API__ (API para interação com fluxo de dados, os resultados são imutáveis. Utilizar operações intermediárias e operações terminais. O Stream faz loops implícitos, o for, while e dowhile são explícitos ou seja você controla)
  

- __Optional__ (Classe nova do Java para facilitar o trabalho com valores null evitando NullPointerException. Foi criado para ser retorno de valores, não use para ser argumento de parâmetros)
  

- __Reduce__ (Reduce é uma das principais operações final que podem ser feitas em um Stream. Reduce é uma
  operação que transforma os vários valores do Stream em um único valor, é para trabalhar com objetos imutáveis) 
  

- __Collect__ (A operação final collect também é um tipo de Reduce, porém é utilizada para objetos mutáveis. Ou
  seja, ao invés de utilizar a operação reduce com String, provavelmente seria mais eficiente utilizar a
  operação collect com a classe StringBuilder, para evitar a criação de vários objetos do tipo String)
  

- __Lambda Varias Formas__ (Varias formas de executar lambda)
  

- __Method Reference__ (Desenvolver código que utiliza uma referência a método, incluindo a refatoração de uma
  expressão lambda para uma referência a método. A sintaxe de referência a um método é uma novidade do Java 8)
  

- __Debug Lambda__ (Formas para realizar debug de lambda)
  

- __Interfaces Funcionais__ (São novas interfaces para o Java utilizar em conjunto com as lambdas, permitindo assim passar funções como parâmetros. As interfaces descritas aqui estão disponíveis no pacote java.util.function)
  

- __Streams Creation__ (Crie Streams de qualquer coisa. Stream esta disponivel para todas as interfaces que extenderem Collection)