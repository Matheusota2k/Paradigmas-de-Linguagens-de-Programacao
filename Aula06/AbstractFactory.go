package main

import "fmt"

type Sedan interface {
	Info() string
}

type SUV interface {
	Info() string
}

type CarFactory interface {
	NewSedan() Sedan
	NewSUV() SUV
}

type Toyota struct{}
type Ford struct{}

func (*Toyota) NewSedan() Sedan {
	return ToyotaCorolla{}
}

func (*Toyota) NewSUV() SUV {
	return ToyotaRAV4{}
}

func (*Ford) NewSedan() Sedan {
	return FordFusion{}
}

func (*Ford) NewSUV() SUV {
	return FordExplorer{}
}

type ToyotaCorolla struct{}
type ToyotaRAV4 struct{}
type FordFusion struct{}
type FordExplorer struct{}

func (ToyotaCorolla) Info() string {
	return "Toyota Corolla - Sedan"
}

func (ToyotaRAV4) Info() string {
	return "Toyota RAV4 - SUV"
}

func (FordFusion) Info() string {
	return "Ford Fusion - Sedan"
}

func (FordExplorer) Info() string {
	return "Ford Explorer - SUV"
}

func printCars(factory CarFactory) {
	fmt.Println(factory.NewSedan().Info())
	fmt.Println(factory.NewSUV().Info())
}

func main() {
	fmt.Println("Produzindo carros Toyota:")
	printCars(&Toyota{})

	fmt.Println("\nProduzindo carros Ford:")
	printCars(&Ford{})
}
