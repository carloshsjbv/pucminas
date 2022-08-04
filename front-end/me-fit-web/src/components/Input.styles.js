import styled from "styled-components";
import Input from './Input'

export const BigInputText = styled(Input)`
  height: 19px;
  width: 560px;
  border-top: none;
  border-right: none;
  border-left: none;
  border-width: none none thin none;
  outline-width: 0;
  margin: 20px;
  padding: 15px;
  font-size: 18px;
`;

export const SmallInputText = styled(BigInputText)`
  width: 250px;
`;

export const CheckBoxInput = styled(Input)`
`

