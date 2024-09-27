class Pessoa:
    def __init__(self, nome, idade):
        self.nome = nome
        self.idade = idade
        self.endereco = None
    
    def adicionar_endereco(self, endereco):
        self.endereco = endereco
    
    def mostrar_informacoes(self):
        if self.endereco:
            print("Endereço:")
            self.endereco.mostrar_endereco()
        else:
            print("Endereço não disponível")
        print(f"Nome: {self.nome}, Idade: {self.idade}")
    

class Endereco:
    def __init__(self, rua, cidade, estado, cep):
        self.rua = rua
        self.cidade = cidade
        self.estado = estado
        self.cep = cep
        
    def mostrar_endereco(self):
        print(f"Rua: {self.rua}, Cidade: {self.cidade}, Estado: {self.estado}, CEP: {self.cep}")
        

class Empresa:
    def __init__(self, nome, cnpj):
        self.nome = nome
        self.cnpj = cnpj
        self.funcionarios = []
        
    def contratar_funcionario(self, funcionario):
        self.funcionarios.append(funcionario)
        
    def listar_funcionarios(self):
        print(f"Funcionários da empresa {self.nome}:")
        
        # Exibe primeiro os detalhes (endereço, nome, idade) dos funcionários
        for funcionario in self.funcionarios:
            funcionario.mostrar_informacoes()
            print()  # Para adicionar uma linha em branco entre as informações dos funcionários
        
        # Exibe depois a lista com os nomes dos funcionários
        print("Lista de nomes dos funcionários:")
        for funcionario in self.funcionarios:
            print(f"- {funcionario.nome}")
            

def main():
    endereco1 = Endereco("Av. Principal", "Cidade A", "Estado X", "12345-678")
    pessoa1 = Pessoa("João", 25)
    pessoa1.adicionar_endereco(endereco1)

    endereco2 = Endereco("Av. Abecedário", "Cidade B", "Estado Y", "98765-432")
    pessoa2 = Pessoa("Matheus", 20)
    pessoa2.adicionar_endereco(endereco2)

    empresa = Empresa("Empresa ABC", "12.345.678/0001-99")
    empresa.contratar_funcionario(pessoa1)
    empresa.contratar_funcionario(pessoa2)

    empresa.listar_funcionarios()

if __name__ == "__main__":
    main()
