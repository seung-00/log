import classNames from "classnames";
import React from "react";

const EMAIL = "seungyoung.dev@gmail.com"

export default function Footer() {

  return (
      <>
        <br/>
        <hr/>
        <footer className={classNames("text-center", "py-3", "text-gray-600", "font-light")}>
          <p>{EMAIL}</p>
        </footer>
      </>
  )
}
