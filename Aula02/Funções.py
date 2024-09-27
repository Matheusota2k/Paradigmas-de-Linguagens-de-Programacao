import random
import json
import re

def ler_vetor(tamanho=10):
    vetor = []
    for i in range(tamanho):
        vetor.append(int(input("Digite o elemento %d: " % i)))
    return vetor

def calcular_maior_menor(vetor):
    maior = vetor[0]
    menor = vetor[0]

    for i in range(1, len(vetor)):
        if vetor[i] > maior:
            maior = vetor[i]
        elif vetor[i] < menor:
            menor = vetor[i]

    print("O maior elemento do vetor é %d." % maior)
    print("O menor elemento do vetor é %d." % menor)
    return maior, menor

def calcular_soma(vetor):

    x = int(input("Digite o valor de X: "))
    y = int(input("Digite o valor de Y: "))

    soma = vetor[x] + vetor[y]

    print("A soma dos valores nas posições X e Y é {}.".format(soma))

def imprimir(vetor):
    
    print("Elementos do vetor:")
    for elemento in vetor:
        print(elemento)

def gerar_cartela():
    
    numeros = set()
    cartela = []
    for i in range(5):
        numero = random.randint(0, 99)
        while numero in numeros:
            numero = random.randint(0, 99)
        numeros.add(numero)
        cartela.append(numero)
    return cartela

def imprimir_cartela():
    
    cartela = gerar_cartela()
    print("Cartela de bingo:")
    for linha in cartela:
        print(linha)

def validar_numero(numero):
    
    padrao = re.compile(r"^\(\d{2}\) \d{5}-\d{4}$")
    return bool(padrao.match(numero))

def coletar_dados():
    
    contatos = {}
    while True:
        nome = input("Digite o nome do contato (ou 'sair' para encerrar): ")
        if nome.lower() == 'sair':
            break

        numero = input("Digite o número de telefone (formato: (11) 12345-6789): ")
        if not validar_numero(numero):
            print("Número de telefone inválido. Tente novamente.")
            continue

        contatos[nome] = numero
    return contatos

def salvar_em_arquivo(contatos, nome_arquivo):
    with open(nome_arquivo, 'w') as arquivo:
        json.dump(contatos, arquivo, indent=4)

def carregar_do_arquivo(nome_arquivo):
    try:
        with open(nome_arquivo, 'r') as arquivo:
            contatos = json.load(arquivo)
    except FileNotFoundError:
        contatos = {}
    return contatos

def exibir_contatos(contatos):
    if contatos:
        for nome, numero in contatos.items():
            print(f"Nome: {nome}, Telefone: {numero}")
    else:
        print("Nenhum contato encontrado.")
