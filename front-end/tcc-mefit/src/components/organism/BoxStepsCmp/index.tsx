import React, { useRef } from 'react';
import AnimatedCmp from '../Fade';
import { IStepCmp } from './interfaces';
import {
  StyContainer,
  StyCurrentStepBar,
  StyStepBar,
  StyStepBarContainer,
} from './styles';

interface BoxStepsCmpProps {
  id: string;
  steps: React.FC<IStepCmp>[];
}

const BoxStepsCmp: React.FC<BoxStepsCmpProps> = ({ id, steps = [] }) => {
  const stepRef = useRef<any>(null);
  const stepBarRef = useRef<any>(null);
  function handleNextStep(event: any) {
    event.preventDefault();
    stepRef.current.scrollLeft += stepRef.current.offsetWidth;
    stepBarRef.current.scrollLeft += stepRef.current.offsetWidth;
  }
  function handlePreviousStep(event: any) {
    event.preventDefault();
    stepRef.current.scrollLeft -= stepRef.current.offsetWidth;
    stepBarRef.current.scrollLeft -= stepRef.current.offsetWidth;
  }

  return (
    <AnimatedCmp>
      <StyStepBarContainer>
        <StyCurrentStepBar ref={stepBarRef} />
        <StyStepBar></StyStepBar>
        <StyStepBar></StyStepBar>
        <StyStepBar></StyStepBar>
      </StyStepBarContainer>
      <StyContainer ref={stepRef} id={`step-container-${id}`}>
        {steps.map((Step: React.FC<IStepCmp>, index: number) => {
          return (
            <Step
              id={`step-${id}-${index}`}
              key={`${id}-${index}`}
              next={handleNextStep}
              prev={handlePreviousStep}
            />
          );
        })}
      </StyContainer>
    </AnimatedCmp>
  );
};

export default BoxStepsCmp;
