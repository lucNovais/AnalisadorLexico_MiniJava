# Trabalho Prático - Analisador Léxico

Analisador Léxico desenvolvido para o Trabalho Prático da disciplina de Compiladores I. Este analisador verifica se expressões da linguagem MiniJava estão de acordo com a sintaxe definida.

### Alunos

- Isac Lopes
- Lucas Novais
- Marcos Alexandre

### Exemplo de funcionamento

- Para o arquivo `entrada.txt`, temos a seguinte saída:

```txt
Tokens coletados:

ID: [Factorial, a, Fac, ComputeFac, num, num_aux, num, num_aux, num_aux, num, num_aux]
OP: [<, =, =, *]
DELIM: [{, (, [, ], ), {, (, ), }, }, {, (, ), {, (, ), }, }]
DECL: [class, public, static, void, main, new, class, public]
FLUXO: [System.out.println, Fac().ComputeFac(10), if, else, (this.ComputeFac(num-1)), return]
TIPO: [String, int, int, int]
COMMENT: []
```
