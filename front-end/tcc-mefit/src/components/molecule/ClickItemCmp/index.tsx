import React, { ReactElement, useEffect } from 'react';
import { CircleSpinner, Text } from '../../index';
import { StyContainer, StyIconContainer } from './styles';

interface IClickItemCmp {
  id: string;
  label: string;
  onChange?: (...props: any) => void;
  onClick?: (...props: any) => void;
  loading: boolean;
  disable?: boolean;
  icon?: ReactElement;
}

const ClickItemCmp: React.FC<IClickItemCmp> = ({
  id,
  label,
  onChange = () => null,
  onClick = () => null,
  loading = false,
  disable = false,
  icon,
}) => {
  useEffect(() => {
    if (id) {
      const component: any = document.getElementById(id);

      component.addEventListener('click', (e: any) => {
        let x = e.clientX - e.target.offsetLeft;
        let y = e.clientY - e.target.offsetTop;

        let ripples = document.createElement('span');
        ripples.classList.add('ripple');
        ripples.style.left = `${x}px`;
        ripples.style.top = `${y}px`;
        ripples.style.zIndex = '2';
        component.appendChild(ripples);

        setTimeout(() => {
          ripples.remove();
        }, 1000);
      });
    }
  }, [id]);

  return (
    <StyContainer
      id={id}
      onClick={onClick}
      onChange={onChange}
      disable={disable}
    >
      {loading ? (
        <CircleSpinner />
      ) : (
        <>
          <StyIconContainer disable={disable}>{icon}</StyIconContainer>
          <Text value={label} />
        </>
      )}
    </StyContainer>
  );
};

export default ClickItemCmp;
