import { Measures } from '../Sizes';

export enum TypographyText {
  xxsmall = 5,
  xsmall = 7,
  small = 11,
  medium = 16,
  large = 24,
  xlarge = 36,
  xxlarge = 54,
}

export enum Scale {
  normal = 1,
  medium = 1.2,
  hight = 1.5,
}

export const Typography = (
  typographyText: TypographyText,
  fontMeasures?: Measures,
  scale?: Scale,
): string => {
  fontMeasures = fontMeasures ? fontMeasures : Measures.px;
  typographyText = scale ? typographyText * scale : typographyText;
  return `${TypographyText}${fontMeasures}`;
};
