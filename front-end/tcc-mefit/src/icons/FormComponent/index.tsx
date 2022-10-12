import React from 'react';

interface IFormComponentIcon {
  fill: string;
  width: string;
  height: string;
}

export const FormComponentIcon: React.FC<IFormComponentIcon> = ({
  fill = '#000000',
  width = '12px',
  height = '12px',
}) => {
  return (
    <svg
      fill={fill}
      xmlns="http://www.w3.org/2000/svg"
      viewBox="0 0 16 16"
      width={width}
      height={height}
    >
      <path d="M 4.5 2 C 3.675781 2 3 2.675781 3 3.5 L 3 12.5 C 3 13.324219 3.675781 14 4.5 14 L 11.5 14 C 12.324219 14 13 13.324219 13 12.5 L 13 5.292969 L 9.707031 2 Z M 4.5 3 L 9 3 L 9 6 L 12 6 L 12 12.5 C 12 12.78125 11.78125 13 11.5 13 L 4.5 13 C 4.21875 13 4 12.78125 4 12.5 L 4 3.5 C 4 3.21875 4.21875 3 4.5 3 Z M 10 3.707031 L 11.292969 5 L 10 5 Z" />
    </svg>
  );
};
