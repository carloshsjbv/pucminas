import React from 'react';

interface IBookIcon {
  fill?: string;
  width?: string;
  height?: string;
}

const BookIcon: React.FC<IBookIcon> = ({
  fill = '#000000',
  width = '12px',
  height = '12px',
}) => {
  return (
    <svg
      fill={fill}
      xmlns="http://www.w3.org/2000/svg"
      viewBox="0 0 24 24"
      width={width}
      height={height}
    >
      <path d="M 6 2 C 4.895 2 4 2.895 4 4 L 4 19 C 4 20.64497 5.3550302 22 7 22 L 20 22 L 20 20 L 7 20 C 6.4349698 20 6 19.56503 6 19 C 6 18.43497 6.4349698 18 7 18 L 20 18 L 20 17 L 20 16 L 20 2 L 16 2 L 16 12 L 13 10 L 10 12 L 10 2 L 6 2 z" />
    </svg>
  );
};

export default BookIcon;