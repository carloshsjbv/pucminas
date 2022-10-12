import React from 'react';
import {
  StyPageCircleContainer,
  StySpinOne,
  StySpinTwo,
  StySpinnerCircle,
} from './styles';

interface ISpinnerCircleCmp {}

const SpinnerCircleCmp: React.FC<ISpinnerCircleCmp> = ({}) => {
  return (
    <StyPageCircleContainer id="pageContainer">
      <StySpinnerCircle>
        <StySpinOne />
        <StySpinTwo />
      </StySpinnerCircle>
    </StyPageCircleContainer>
  );
};

export default SpinnerCircleCmp;
