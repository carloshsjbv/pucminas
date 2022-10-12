import React from 'react';

interface IPageComponentIcon {
  fill: string;
  width: string;
  height: string;
}

export const PageComponentIcon: React.FC<IPageComponentIcon> = ({
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
      <path d="M 2.5 1 C 1.675781 1 0.996094 1.675781 1 2.5 L 1 12.5 C 1 13.324219 1.675781 14 2.5 14 L 12.5 14 C 13.324219 14 14 13.324219 14 12.5 L 14 2.5 C 14 1.675781 13.324219 1 12.5 1 Z M 2.5 2 L 12.5 2 C 12.78125 2 13 2.21875 13 2.5 L 13 4 L 2 4 L 2 2.5 C 2 2.21875 2.214844 2 2.5 2 Z M 2 5 L 13 5 L 13 12.5 C 13 12.78125 12.78125 13 12.5 13 L 2.5 13 C 2.214844 13 2 12.78125 2 12.5 Z M 6 6 L 6 7 L 9 7 L 9 6 Z" />
    </svg>
  );
};
