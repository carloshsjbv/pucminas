import { createGlobalStyle } from 'styled-components';

export default createGlobalStyle`

  * {
    font-family:'Source Sans Pro';
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    outline: 0;
    scrollbar-width:thin;
    ::-webkit-scrollbar{
      width: 0.75px;
    }
  }
  html, body, #root{
        height:100%;
  }
  body {
    -webkit-font-smoothing: antialiased !important;

  }
  body, input, button {
    //font-family: 'Roboto Slab', cursive;
   font-family:'Source Sans Pro', sans-serif;
    font-size: 16px;
    height:100%;
  }
  h1, h2, h3, h4, h5, h6, strong {
    font-weight: 500;
  }
  button {
    cursor: pointer;
  }
`;
