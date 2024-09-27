from Funções import coletar_dados, salvar_em_arquivo, carregar_do_arquivo, exibir_contatos
from Funções import ler_vetor, calcular_maior_menor, imprimir, calcular_soma, gerar_cartela, imprimir_cartela

def main():
    
    nome_arquivo = 'agenda_telefonica.json'
    contatos = carregar_do_arquivo(nome_arquivo)
    
    while True:
        print("\nMenu:")
        print("1. Adicionar/Editar Contato")
        print("2. Exibir Contatos")
        print("3. Operações com Vetor")
        print("4. Gerar Cartela de Bingo")
        print("5. Salvar e Sair")
        escolha = input("Escolha uma opção: ")

        if escolha == '1':
            novos_contatos = coletar_dados()
            contatos.update(novos_contatos)
        elif escolha == '2':
            exibir_contatos(contatos)
        elif escolha == '3':
            vetor = ler_vetor()
            imprimir(vetor)
            calcular_soma(vetor)
        elif escolha == '4':
            imprimir_cartela()
        elif escolha == '5':
            salvar_em_arquivo(contatos, nome_arquivo)
            print(f"Dados salvos em '{nome_arquivo}'.")
            break
        else:
            print("Opção inválida. Tente novamente.")

if __name__ == "__main__":
    main()