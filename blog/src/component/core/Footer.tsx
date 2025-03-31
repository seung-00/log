import React from "react";
import Fitting from "./Fitting";

const EMAIL = "seungyoung.dev@gmail.com"

export default function Footer() {

  return (
      <Fitting>
        <br/>
        <hr/>
        <footer className="text-center py-3 text-gray-600 font-light">
          <p>{EMAIL}</p>
        </footer>
      </Fitting>
  )
}
