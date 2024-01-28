import {useRouteError} from "react-router-dom";

interface Error {
  statusText: string
  message: string
}

const isError = (error: unknown): error is Error => {
  if (!error) {
    return false
  }

  return error.hasOwnProperty("statusText") && error.hasOwnProperty("message")
}

export default function ErrorPage() {
  const error = useRouteError();
  console.error(error);

  return (
      <div id="error-page">
        <h1>Oops!</h1>
        <p>Sorry, an unexpected error has occurred.</p>
        <p>
          {isError(error) && (
              <i>{error.statusText || error.message}</i>
          )}
        </p>
      </div>
  );
}
