## Anotações Camada **UseCase**
- As Interfaces são pontos de conexões com as camadas mais
externas. 
- Nas camadas internas, são criadas interfaces e nas camadas mais
externas, essas interfaces são implementadas.
- As camadas mais externas tem acesso as camadas mais internas, m,as
as camadas mais internas não tem acesso as camadas externas.


## Camada Application
- Essa camada cria as implementações das interfaces definidas na camada de **UseCase**
- O pacote `gateway` guard as *interfaces and adapters*, ou seja, a comunicação
com a proxima camada e como os metodos serão implementados.