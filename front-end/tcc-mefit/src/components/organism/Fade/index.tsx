import React from 'react';
import { StyContainer } from './styles';

interface AnimatedCmpProps {}

const AnimatedCmp: React.FC<AnimatedCmpProps> = ({ children }) => {
  return <StyContainer>{children}</StyContainer>;
};

export default AnimatedCmp;
