import { Measures } from '../Sizes';

export enum ElementBaseSize {
  base05 = 5,
  base10 = 10,
  base15 = 15,
  base20 = 20,
  base25 = 25,
  base30 = 30,
  base35 = 35,
  base40 = 40,
  base45 = 45,
  base50 = 50,
  base55 = 55,
  base60 = 60,
  base65 = 60,
  base70 = 70,
  base75 = 75,
  base80 = 80,
  base85 = 85,
  base90 = 90,
  base95 = 95,
  base100 = 100,
}

export function ElementSizes(
  elementBaseSize: ElementBaseSize,
  elementMeasures?: Measures,
  baseNumber?: number,
): string {
  elementMeasures = elementMeasures ? elementMeasures : Measures.px;
  elementBaseSize = baseNumber ? elementBaseSize * baseNumber : elementBaseSize;
  return `${elementBaseSize}${elementMeasures}`;
}
