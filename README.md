# 🛒 Sistema de Vendas com Java (Swing + JPA)

Sistema desktop desenvolvido em Java com interface gráfica utilizando Swing e persistência de dados com JPA/Hibernate.

## 📌 Funcionalidades

✔️ Cadastro de clientes
✔️ Cadastro de produtos
✔️ Cadastro de vendas
✔️ Seleção de cliente
✔️ Seleção de produtos
✔️ Carrinho de compras (vários itens por venda)
✔️ Cálculo automático de total por item
✔️ Cálculo automático do total da venda
✔️ Controle de estoque automático
✔️ Histórico de vendas
✔️ Relatório de vendas por dia
✔️ Total de faturamento diário

---

## 🧠 Regras de Negócio

* O preço do produto é carregado automaticamente ao selecionar o item
* O usuário não digita o preço manualmente
* O preço é salvo no `Item_venda` para manter histórico
* O estoque é atualizado automaticamente após cada venda
* A data da venda é gerada automaticamente pelo sistema

---

## 🏗️ Estrutura do Projeto

### 📦 Entidades

* `Venda`
* `Item_venda`
* `Produto`
* `Cliente`

### 📂 DAO (Data Access Object)

* `VendaDAO`
* `Item_vendaDAO`
* `ProdutoDAO`
* `ClienteDAO`

### 🖥️ Telas

* Menu
* Tela Cliente
* Tela de Produto
* Tela de Vendas
* Tela de Histórico
* Tela de Relatório do Dia

---

## ⚙️ Tecnologias Utilizadas

* Java
* Java Swing (Interface gráfica)
* JPA / Hibernate
* MySQL
* NetBeans

---

## 🧮 Funcionalidades Técnicas

* Relacionamento `@ManyToOne` entre entidades
* Transações com `EntityManager`
* Uso de `List` para controle de carrinho
* Atualização de estoque em tempo real
* Query JPQL para relatórios

---

## 📊 Relatório do Dia

O sistema permite:

* Selecionar uma data
* Listar todas as vendas do dia
* Calcular o total faturado

---

## 🚀 Como Executar

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
```

2. Abra no NetBeans

3. Configure o banco de dados (MySQL)

4. Execute o projeto

---

## 👩‍💻 Autora

Projeto desenvolvido por **Giovana Correia** 💻✨


