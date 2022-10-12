import React from 'react';
import { StyContainer } from './styles';

interface ITextCmp {
  value: string;
  fontSize?: string;
  color?: string;
}

const TextCmp: React.FC<ITextCmp> = ({ value, fontSize, color }) => {
  return <StyContainer>{value}</StyContainer>;
};

export default TextCmp;
